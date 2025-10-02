package DecoratorExample;

public class PercentDamageCalculator extends DamageCalculatorDecorator{

    private final float percent;

    public PercentDamageCalculator(DamageCalculator damageCalculator , float percent) {
        super(damageCalculator);
        this.percent = percent;
    }

    @Override
    public float CalculateDamage() {
        return getDamageCalculator().CalculateDamage() * (1 + (percent / 100f));
    }
}
