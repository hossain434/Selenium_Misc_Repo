package PageObjectsDesignUsingFluentStyle2;
public class ProductSearchPage extends Page {

    public void search(){
       System.out.println("searching for product");
    }
    
    public void choose(){
        System.out.println("found a product");
    }
    
    @Override
    public boolean isAt() {
        return true;
    }

}