package DecoratorExample;

public class ClientDamageCalculator extends DamageCalculator{
    private final float defaultDamage;

    public ClientDamageCalculator(float defaultDamage) {
        this.defaultDamage = defaultDamage;
    }

    @Override
    public float CalculateDamage() {
        return defaultDamage;
    }
}
