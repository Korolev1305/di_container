package di_container.config;

import di_container.service.PaymentSystem;
import di_container.service.impl.CardPaymentSystem;

import java.util.Map;

public class JavaConfiguration implements Configuration {
    @Override
    public String getPackageToScan() {
        return "di_container";
    }

    @Override
    public Map<Class, Class> getInterfaceToImplementationMap() {
        return Map.of(PaymentSystem.class, CardPaymentSystem.class);
    }
}
