package com.al.exports.pspims.services;

import com.al.exports.pspims.domain.PaymentDetails;
import com.al.exports.pspims.repository.PaymentDetailsRepository;
import com.al.exports.pspims.shared.exceptions.ResourceNotFoundException;
import com.al.exports.pspims.shared.mapper.PaymentDetailsMapper;
import com.al.exports.pspims.shared.model.PaymentDetailsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentDetailsServiceImpl implements PaymentDetailsService {

    private final PaymentDetailsRepository paymentDetailsRepository;
    private final PaymentDetailsMapper paymentDetailsMapper;

    @Override
    public Page<PaymentDetailsDTO> findAll(Pageable pageable) {
        Page<PaymentDetails> paymentDetails = paymentDetailsRepository.findAll(pageable);
        return paymentDetails.map(paymentDetailsMapper::paymentDetailsToPaymentDetailsDTO);
    }

    @Override
    public PaymentDetailsDTO findById(UUID uuid) {
        return paymentDetailsRepository
                .findById(uuid)
                .map(paymentDetailsMapper::paymentDetailsToPaymentDetailsDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Not found payment detail with id: " + uuid));
    }

    @Override
    public PaymentDetailsDTO create(PaymentDetailsDTO paymentDetailsDTO) {
        return saveAndReturnDTO(paymentDetailsMapper.paymentDetailsDtoToPaymentDetails(paymentDetailsDTO));
    }

    @Override
    public PaymentDetailsDTO update(UUID id, PaymentDetailsDTO paymentDetailsDTO) {
        PaymentDetails paymentDetails = paymentDetailsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found payment detail with id: " + id));
        paymentDetails.setPaymentStatus(paymentDetailsDTO.getPaymentStatus());
        paymentDetails.setPaymentAmount(paymentDetailsDTO.getPaymentAmount());
        paymentDetails.setPaymentDate(paymentDetailsDTO.getPaymentDate());
        paymentDetails.setInvoiceNo(paymentDetailsDTO.getInvoiceNo());
        paymentDetails.setPaymentMethod(paymentDetailsDTO.getPaymentMethod());
        return saveAndReturnDTO(paymentDetails);
    }

    @Override
    public PaymentDetailsDTO patch(UUID id, PaymentDetailsDTO paymentDetailsDTO) {
        return paymentDetailsRepository
                .findById(id)
                .map(paymentDetails -> {
                    if (paymentDetailsDTO.getPaymentStatus() != null) {
                        paymentDetails.setPaymentStatus(paymentDetailsDTO.getPaymentStatus());
                    }
                    if (paymentDetailsDTO.getPaymentAmount() != null) {
                        paymentDetails.setPaymentAmount(paymentDetailsDTO.getPaymentAmount());
                    }
                    if (paymentDetailsDTO.getPaymentDate() != null) {
                        paymentDetails.setPaymentDate(paymentDetailsDTO.getPaymentDate());
                    }
                    if (paymentDetailsDTO.getInvoiceNo() != null) {
                        paymentDetails.setInvoiceNo(paymentDetailsDTO.getInvoiceNo());
                    }
                    if (paymentDetailsDTO.getPaymentMethod() != null) {
                        paymentDetails.setPaymentMethod(paymentDetailsDTO.getPaymentMethod());
                    }
                    return saveAndReturnDTO(paymentDetails);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Not found payment detail with id: " + id));
    }

    @Override
    public void deleteById(UUID uuid) {
        paymentDetailsRepository.deleteById(uuid);
    }

    private PaymentDetailsDTO saveAndReturnDTO(PaymentDetails paymentDetails) {
        PaymentDetails returnPaymentDetails = paymentDetailsRepository.save(paymentDetails);
        return paymentDetailsMapper.paymentDetailsToPaymentDetailsDTO(returnPaymentDetails);
    }
}
