package com.al.exports.pspims.services;


import com.al.exports.pspims.domain.ProdOrderDetails;
import com.al.exports.pspims.repository.ProdOrderDetailsRepository;
import com.al.exports.pspims.shared.exceptions.ResourceNotFoundException;
import com.al.exports.pspims.shared.mapper.ProdOrderDetailsMapper;
import com.al.exports.pspims.shared.model.ProdOrderDetailsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProdOrderDetailsServiceImpl implements ProdOrderDetailsService {

    private final ProdOrderDetailsRepository prodOrderDetailsRepository;
    private final ProdOrderDetailsMapper prodOrderDetailsMapper;

    @Override
    public Page<ProdOrderDetailsDTO> findAll(Pageable pageable) {
        Page<ProdOrderDetails> prodOrderDetails = prodOrderDetailsRepository.findAll(pageable);
        return prodOrderDetails.map(prodOrderDetailsMapper::prodOrderDetailsToProdOrderDetailsDTO);
    }

    @Override
    public ProdOrderDetailsDTO findById(UUID uuid) {
        return prodOrderDetailsRepository.findById(uuid).map(prodOrderDetailsMapper::prodOrderDetailsToProdOrderDetailsDTO).orElseThrow(() -> new ResourceNotFoundException("Not found production order detail with id: " + uuid));
    }

    @Override
    public ProdOrderDetailsDTO create(ProdOrderDetailsDTO prodOrderDetailsDTO) {
        return saveAndReturnDTO(prodOrderDetailsMapper.prodOrderDetailsDtoToProdOrderDetails(prodOrderDetailsDTO));
    }

    @Override
    public ProdOrderDetailsDTO update(UUID id, ProdOrderDetailsDTO prodOrderDetailsDTO) {
        ProdOrderDetails prodOrderDetails = prodOrderDetailsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found production order detail with id: " + id));
        prodOrderDetails.setProdQuantity(prodOrderDetailsDTO.getProdQuantity());
        prodOrderDetails.setProdDate(prodOrderDetailsDTO.getProdDate());
        prodOrderDetails.setProductionQuantityMeasure(prodOrderDetailsDTO.getProductionQuantityMeasure());
        prodOrderDetails.setProdStatus(prodOrderDetailsDTO.getProdStatus());
        return saveAndReturnDTO(prodOrderDetails);
    }

    @Override
    public ProdOrderDetailsDTO patch(UUID id, ProdOrderDetailsDTO prodOrderDetailsDTO) {
        return prodOrderDetailsRepository
                .findById(id)
                .map(prodOrderDetails -> {
                    if (prodOrderDetailsDTO.getProdQuantity() != null) {
                        prodOrderDetails.setProdQuantity(prodOrderDetailsDTO.getProdQuantity());
                    }
                    if (prodOrderDetailsDTO.getProdDate() != null) {
                        prodOrderDetails.setProdDate(prodOrderDetailsDTO.getProdDate());
                    }
                    if (prodOrderDetailsDTO.getProductionQuantityMeasure() != null) {
                        prodOrderDetails.setProductionQuantityMeasure(prodOrderDetailsDTO.getProductionQuantityMeasure());
                    }
                    if (prodOrderDetailsDTO.getProdStatus() != null) {
                        prodOrderDetails.setProdStatus(prodOrderDetailsDTO.getProdStatus());
                    }
                    return saveAndReturnDTO(prodOrderDetails);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Not found production order detail with id: " + id));
    }

    @Override
    public void deleteById(UUID uuid) {
        prodOrderDetailsRepository.deleteById(uuid);
    }

    private ProdOrderDetailsDTO saveAndReturnDTO(ProdOrderDetails prodOrderDetails) {
        ProdOrderDetails returnProdOrderDetails = prodOrderDetailsRepository.save(prodOrderDetails);
        return prodOrderDetailsMapper.prodOrderDetailsToProdOrderDetailsDTO(returnProdOrderDetails);
    }
}
