import { checkIsSelected } from "./helpers";
import ProductCard from "./ProductCard";
import { Product } from "./Types";
type props={
    products: Product[];
    selectedProducts: Product[];
    onSelectProduct: (product: Product) => void;
}

function ProductsList({products, onSelectProduct, selectedProducts}:props){
    
    return(
        <div className="orders-list-container">
            <div className="orders-list-items">
                {products.map(product =>(
                    <ProductCard 
                        key={product.id} 
                        product={product} 
                        onSelectProduct={onSelectProduct}
                        isSelected={checkIsSelected(selectedProducts, product)}
                    />
                ))}
            </div>
        </div>
    )
}
export default ProductsList;