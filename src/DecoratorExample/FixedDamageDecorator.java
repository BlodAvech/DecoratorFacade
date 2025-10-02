package DecoratorExample;

public class FixedDamageDecorator extends DamageCalculatorDecorator{

    private final float damage;

    public FixedDamageDecorator(DamageCalculator damageCalculator , float damage) {
        super(damageCalculator);
        this.damage = damage;
    }

    @Override
    public float CalculateDamage() {
        return getDamageCalculator().CalculateDamage() + damage;
    }
}
