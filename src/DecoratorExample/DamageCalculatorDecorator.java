package DecoratorExample;

public abstract class DamageCalculatorDecorator extends DamageCalculator {

    private final DamageCalculator damageCalculator;

    public DamageCalculatorDecorator(DamageCalculator damageCalculator) {
        this.damageCalculator = damageCalculator;
    }

    @Override
    public float CalculateDamage() {
        return damageCalculator.CalculateDamage();
    }

    public DamageCalculator getDamageCalculator() {
        return damageCalculator;
    }
}
