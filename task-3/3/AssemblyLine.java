import java.util.Map;

public class AssemblyLine implements IAssemblyLine{
    private Body body;
    private Chassis chassis;
    private Engine engine;

    AssemblyLine(ProductPart body, ProductPart chassis, ProductPart engine) {
        this.body = (Body) body;
        this.chassis = (Chassis) chassis;
        this.engine = (Engine) engine;
        System.out.println("  ПЕРЕДАЛИ ДЕТАЛИ НА ЛИНИЮ СБОРКИ");
    }

    @Override
    public Product assembleProduct(Product product) {
        System.out.println("  НАЧАЛО_СБОРКИ_ПРОДУКТА");
        product.initialFirstPart(this.body);
        product.initialSecondPart(this.chassis);
        product.initialThirdPart(this.engine);
        return product;
    }
}
