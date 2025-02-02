package com.al.exports.pspims.bootstrap;

import com.al.exports.pspims.domain.*;
import com.al.exports.pspims.repository.*;
import com.al.exports.pspims.shared.enums.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

    private final AgentRepository agentRepository;
    private final BeverageIngredientsRepository beverageIngredientsRepository;
    private final BeverageTypeRepository beverageTypeRepository;
    private final BeverageProdOrderRepository beverageProdOrderRepository;
    private final CoconutPurchaseRepository coconutPurchaseRepository;
    private final CoconutWaterProdOrderRepository coconutWaterProdOrderRepository;
    private final CopraSaleRepository copraSaleRepository;
    private final CustomerRepository customerRepository;
    private final DeliveryVehicleRepository deliveryVehicleRepository;
    private final InventoryRepository inventoryRepository;
    private final OrderRepository orderRepository;
    private final PaymentDetailsRepository paymentDetailsRepository;
    private final ProdOrderDetailsRepository prodOrderDetailsRepository;
    private final ShippingPlanRepository shippingPlanRepository;
    private final SupplierRepository supplierRepository;
    private final SupplierPaymentDetailsRepository supplierPaymentDetailsRepository;
    private final VinegarProdOrderRepository vinegarProdOrderRepository;

    @Override
    public void run(String... args) throws Exception {
        int agentSize = agentRepository.findAll().size();
        int bISize = beverageIngredientsRepository.findAll().size();
        int bPO = beverageProdOrderRepository.findAll().size();
        int bT = beverageTypeRepository.findAll().size();
        int cP = coconutPurchaseRepository.findAll().size();
        int cWPO = coconutWaterProdOrderRepository.findAll().size();
        int cS = copraSaleRepository.findAll().size();
        int customer = customerRepository.findAll().size();
        int dV = deliveryVehicleRepository.findAll().size();
        int inventory = inventoryRepository.findAll().size();
        int order = orderRepository.findAll().size();
        int supSize = supplierRepository.findAll().size();
        int sPDSize = supplierPaymentDetailsRepository.findAll().size();
        int vPO = vinegarProdOrderRepository.findAll().size();

        if (agentSize == 0) {
            loadAgentData();
        }
        if (dV == 0) {
            loadDeliveryVehicle();
        }
        if (inventory == 0) {
            loadInventory();
        }
        if (bT == 0) {
            loadBeverageType();
        }
        if (bISize == 0) {
            loadBeverageIngredients();
        }
        if (bPO == 0) {
            loadBeverageProdOrder();
        }
        if (supSize == 0) {
            loadSupplier();
        }
        if (cP == 0) {
            loadCoconutPurchase();
        }
        if (customer == 0) {
            loadCustomer();
        }
        if (cWPO == 0) {
            loadCoconutWaterProdOrder();
        }
        if (cS == 0) {
            loadCopraSale();
        }
        if (order == 0) {
            loadOrder();
        }
        if (sPDSize == 0) {
            loadSupplierPaymentDetails();
        }
        if (vPO == 0) {
            loadVinegarProdOrder();
        }
    }

    private void loadAgentData() {
        Agent newAgent = Agent.builder()
                .firstName("Kaveen")
                .lastName("Prabodhya")
                .username("kaveen")
                .password("password")
                .agentDepartment(AgentDepartmentTypeEnum.LOGISTICS)
                .address("75 A, Colombo 01")
                .email("agent1@example.com")
                .performanceRate(3.7f)
                .build();

        Agent newAdmin = Agent.builder()
                .firstName("thivanka")
                .lastName("liyanage")
                .username("thivanka")
                .password("password")
                .role(Role.ROLE_ADMIN)
                .agentDepartment(AgentDepartmentTypeEnum.LOGISTICS)
                .address("75 A, Colombo 01")
                .email("admin@example.com")
                .performanceRate(3.7f)
                .build();

        agentRepository.save(newAgent);
        agentRepository.save(newAdmin);
    }

    private void loadBeverageIngredients() {
        Optional<BeverageType> type = beverageTypeRepository.findAll().stream().findFirst();
        if (type.isPresent()) {
            BeverageIngredients beverageIngredients = BeverageIngredients.builder()
                    .ingredientName("coconut milk")
                    .ingredientMeasure(IngredientMeasureEnum.GRAMS)
                    .measureAmount(350.0f)
                    .beverageType(type.get())
                    .build();

            beverageIngredientsRepository.save(beverageIngredients);
        }
    }

    private void loadBeverageProdOrder() {

        Optional<BeverageType> beverageType = beverageTypeRepository.findAll().stream().findFirst();

        ProdOrderDetails prodOrderDetails = getProdOrderDetails();
        prodOrderDetailsRepository.save(prodOrderDetails);

        if (beverageType.isPresent()) {
            BeverageProdOrder beverageProdOrder = BeverageProdOrder.builder()
                    .prodOrderDetails(prodOrderDetails)
                    .beverageType(beverageType.get())
                    .build();
            beverageProdOrderRepository.save(beverageProdOrder);
        }
    }

    private void loadBeverageType() {

        BeverageType beverageType = BeverageType.builder()
                .beverageName("Organic Coconut Water")
                .beverageDescription("Refreshing natural coconut water with no preservatives. Rich in electrolytes and essential minerals.")
                .isActive(true)
                .nutritionInfo("Per 500ml: Calories 45, Carbohydrates 11g, Sugars 8g, Potassium 600mg, Sodium 35mg")
                .build();

        beverageTypeRepository.save(beverageType);

    }

    private void loadCoconutPurchase() {

        Optional<Inventory> inventory = inventoryRepository.findAll().stream().findFirst();

        Optional<Supplier> supplier = supplierRepository.findAll().stream().findFirst();

        if (inventory.isPresent() && supplier.isPresent()) {
            CoconutPurchase coconutPurchase = CoconutPurchase.builder()
                    .purchaseDate(new Date())
                    .coconutQualityGrade(CoconutQualityGradeEnum.B)
                    .pricePerUnit(100.0f)
                    .purchaseQuantity(30)
                    .inventory(inventory.get())
                    .supplier(supplier.get())
                    .build();

            coconutPurchaseRepository.save(coconutPurchase);
        }
    }

    private void loadCoconutWaterProdOrder() {
        ProdOrderDetails prodOrderDetails = this.getProdOrderDetails();

        prodOrderDetailsRepository.save(prodOrderDetails);

        CoconutWaterProdOrder coconutWaterProdOrder = CoconutWaterProdOrder.builder()
                .prodOrderDetails(prodOrderDetails)
                .build();

        coconutWaterProdOrderRepository.save(coconutWaterProdOrder);
    }

    private void loadCopraSale() throws ParseException {
        Optional<Customer> customer = customerRepository.findAll().stream().findFirst();

        if (customer.isPresent()) {

            ShippingPlan shippingPlan = this.getShippingPlan();
            shippingPlanRepository.save(shippingPlan);

            PaymentDetails paymentDetails = this.getPaymentDetails();
            paymentDetailsRepository.save(paymentDetails);

            CopraSale copraSale = CopraSale.builder()
                    .saleDate(new Date())
                    .saleQuantity(8)
                    .pricePerQuantity(28.99f)
                    .customer(customer.get())
                    .shippingPlan(shippingPlan)
                    .paymentDetails(paymentDetails)
                    .build();

            copraSaleRepository.save(copraSale);
        }
    }

    private void loadCustomer() {
        Optional<Agent> agent = agentRepository.findAll().stream().findFirst();

        if (agent.isPresent()) {
            Customer customer = Customer.builder()
                    .firstName("Joe")
                    .lastName("Joe")
                    .address("342, Negombo")
                    .email("example@domain.com")
                    .agent(agent.get())
                    .customerType(CustomerType.INDIVIDUAL)
                    .creditLimit(1000.00f)
                    .build();

            customerRepository.save(customer);
        }
    }

    private void loadDeliveryVehicle() {
        DeliveryVehicle deliveryVehicle = DeliveryVehicle.builder()
                .vehicleRegNo(BigInteger.valueOf(12_345_678))
                .vehicleType(VehicleTypeEnum.CAR)
                .availabilityStatus(VehicleAvailabilityStatusEnum.AVAILABLE)
                .build();

        DeliveryVehicle deliveryVehicle2 = DeliveryVehicle.builder()
                .vehicleRegNo(BigInteger.valueOf(52_555_645))
                .vehicleType(VehicleTypeEnum.VAN)
                .availabilityStatus(VehicleAvailabilityStatusEnum.AVAILABLE)
                .build();

        deliveryVehicleRepository.save(deliveryVehicle);
        deliveryVehicleRepository.save(deliveryVehicle2);
    }

    private void loadInventory() {
        Inventory inventory = Inventory.builder()
                .inventoryItemType(InventoryItemTypeEnum.CONSUMABLE)
                .inventoryQuantity(1000)
                .inventoryQuantityType(InventoryQuantityTypeEnum.UNIT)
                .maximumStockLevel(5000)
                .minimumStockLevel(0)
                .build();

        inventoryRepository.save(inventory);
    }

    private void loadOrder() throws ParseException {
        Optional<Customer> customer = customerRepository.findAll().stream().findFirst();
        if (customer.isPresent()) {
            Optional<BeverageProdOrder> beverageProdOrder = beverageProdOrderRepository.findAll().stream().findFirst();
            if (beverageProdOrder.isPresent()) {
                PaymentDetails paymentDetails = this.getPaymentDetails();
                paymentDetails.setPaymentAmount(beverageProdOrder.get().getProdOrderDetails().getTotalAmount());
                paymentDetailsRepository.save(paymentDetails);

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date date = dateFormat.parse("12/12/2025");

                Optional<DeliveryVehicle> deliveryVehicle = deliveryVehicleRepository.findAll().stream().skip(1).findFirst();
                if (deliveryVehicle.isPresent()) {
                    ShippingPlan shippingPlan = ShippingPlan.builder()
                            .shippingAddress("No 684, tg road, python")
                            .shippingDate(date)
                            .shippingType(ShippingTypeEnum.LAND)
                            .trackingNumber(UUID.randomUUID())
                            .deliveryVehicle(deliveryVehicle.get())
                            .deliveryType(DeliveryTypeEnum.HOME_DELIVERY)
                            .shippingStatus(ShippingStatusEnum.PENDING)
                            .build();
                    shippingPlanRepository.save(shippingPlan);
                    Order order = Order.builder()
                            .orderDate(new Date())
                            .orderStatus(OrderStatusEnum.CONFIRMED)
                            .coconutWaterProdOrder(null)
                            .beverageProdOrder(beverageProdOrder.get())
                            .vinegarProdOrder(null)
                            .paymentDetails(paymentDetails)
                            .customer(customer.get())
                            .shippingPlan(shippingPlan)
                            .build();

                    System.out.println(order);

                    orderRepository.save(order);
                }
            }
        }
    }

    private PaymentDetails getPaymentDetails() {
        return PaymentDetails.builder()
                .paymentStatus(PaymentStatusEnum.PAID)
                .paymentDate(new Date())
                .paymentMethod(PaymentMethodEnum.CASH)
                .paymentAmount(100.0f)
                .build();
    }

    private ProdOrderDetails getProdOrderDetails() {
        return ProdOrderDetails.builder()
                .prodDate(new Date())
                .pricePerUnit(38.66f)
                .prodQuantity(63.0f)
                .productionQuantityMeasure(ProductionQuantityMeasureEnum.KG)
                .prodStatus(ProdStatusEnum.IN_PROGRESS)
                .build();
    }

    private ShippingPlan getShippingPlan() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateFormat.parse("12/12/2025");
        Optional<DeliveryVehicle> deliveryVehicle = deliveryVehicleRepository.findAll().stream().findFirst();
        return deliveryVehicle.map(vehicle -> ShippingPlan.builder()
                .shippingAddress("No 654, ab road, java")
                .shippingDate(date)
                .shippingType(ShippingTypeEnum.LAND)
                .trackingNumber(UUID.randomUUID())
                .deliveryVehicle(vehicle)
                .deliveryType(DeliveryTypeEnum.HOME_DELIVERY)
                .shippingStatus(ShippingStatusEnum.PENDING)
                .build()).orElse(null);
    }

    private void loadSupplier() {
        Optional<Agent> agent = agentRepository.findAll().stream().findFirst();
        if (agent.isPresent()) {
            Supplier supplier = Supplier.builder()
                    .firstName("Mary")
                    .lastName("Cooper")
                    .email("example2@domain.com")
                    .address("123, asdf, asdfggfd")
                    .supplierStatus(SupplierStatusEnum.ACTIVE)
                    .supplierPaymentTerms(SupplierPaymentTermsEnum.NET_60)
                    .agent(agent.get())
                    .build();

            supplierRepository.save(supplier);
        }
    }

    private void loadSupplierPaymentDetails() {
        Optional<Supplier> supplier = supplierRepository.findAll().stream().findFirst();
        if (supplier.isPresent()) {
            Optional<CoconutPurchase> coconutPurchase = coconutPurchaseRepository.findAll().stream().findFirst();
            if (coconutPurchase.isPresent()) {
                PaymentDetails paymentDetails = this.getPaymentDetails();
                paymentDetails.setPaymentAmount(coconutPurchase.get().getTotalPurchaseCost());
                paymentDetailsRepository.save(paymentDetails);
                SupplierPaymentDetails supplierPaymentDetails = SupplierPaymentDetails.builder()
                        .paymentDetails(paymentDetails)
                        .supplier(supplier.get())
                        .build();

                supplierPaymentDetailsRepository.save(supplierPaymentDetails);
            }
        }
    }

    private void loadVinegarProdOrder() {
        ProdOrderDetails prodOrderDetails = this.getProdOrderDetails();
        prodOrderDetailsRepository.save(prodOrderDetails);
        VinegarProdOrder vinegarProdOrder = VinegarProdOrder.builder()
                .prodOrderDetails(prodOrderDetails)
                .fermentationType(FermentationTypeEnum.CONTROLLED)
                .build();

        vinegarProdOrderRepository.save(vinegarProdOrder);
    }
}
