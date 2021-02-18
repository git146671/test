public class Product implements IProduct{
    Body body;
    Chassis chassis;
    Engine engine;

    @Override
    public void initialFirstPart(ProductPart productPart) {
        this.body = (Body) productPart;
        System.out.println("БЫЛ_УСТАНОВЛЕН_КУЗОВ");
    }

    @Override
    public void initialSecondPart(ProductPart productPart) {
        this.chassis = (Chassis) productPart;
        System.out.println("БЫЛО_УСТАНОВЛЕНО_ШАССИ");
    }

    @Override
    public void initialThirdPart(ProductPart productPart) {
        this.engine = (Engine) productPart;
        System.out.println("БЫЛ_УСТАНОВЛЕН_ДВИГАТЕЛЬ");
    }
}
