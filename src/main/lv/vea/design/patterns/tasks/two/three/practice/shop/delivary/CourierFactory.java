package lv.vea.design.patterns.tasks.two.three.practice.shop.delivary;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Created by m7_anohin_a on 12/1/2017.
 */
public class CourierFactory {

    private final static DpdCourier dpdCourier = new DpdCourier();

    private final static DhlCourier dhlCourier = new DhlCourier();

    private final static List<Courier> COURIERS = new LinkedList<>();

    private CourierFactory() {
        COURIERS.add(dpdCourier);
        COURIERS.add(dhlCourier);
        //nothing to do here
    }

    public static Courier getCourier(String courier) {
        Optional<Courier> courierOptional = COURIERS.stream()
                .filter(i -> i.getName().equals(courier))
                .findFirst();

        if (courierOptional.isPresent()) {
            return courierOptional.get();
        } else {
            throw new RuntimeException("Unknownk courier " + courier);
        }
    }

    public static List<Courier> getAllAvailableCouriers() {
        return COURIERS;
    }
}
