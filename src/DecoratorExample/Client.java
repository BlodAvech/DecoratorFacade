package DecoratorExample;

public class Client
{
    DamageCalculator damageCalculator = new ClientDamageCalculator(10);

    public void Execute()
    {
        addFixedDamage(15);
        addPercentDamage(50);
        addFixedDamage(20);
        addPercentDamage(100);

        System.out.println(damageCalculator.CalculateDamage());
    }

    public void addFixedDamage(float damage)
    {
        damageCalculator = new FixedDamageDecorator(damageCalculator , damage);
    }

    public void addPercentDamage(float percent)
    {
        damageCalculator = new PercentDamageCalculator(damageCalculator , percent);
    }
}
