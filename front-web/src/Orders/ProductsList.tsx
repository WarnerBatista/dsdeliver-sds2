import ProductCard from "./ProductCard";
import { Product } from "./Types";
type props={
    products: Product[];
}

function ProductsList({products}:props){
    
    return(
        <div className="orders-list-container">
            <div className="orders-list-items">
                {products.map(product =>(
                    <ProductCard key={product.id} product={product} />
                ))}
            </div>
        </div>
    )
}
export default ProductsList;