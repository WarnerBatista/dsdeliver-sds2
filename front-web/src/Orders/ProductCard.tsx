import { formatprice } from "./helpers";
import { Product } from "./Types";
type Props={
    product: Product;
    onSelectProduct: (product: Product) => void;
    isSelected: boolean;
}

function ProductCard({product, onSelectProduct, isSelected}:Props){
    return(
        <div className={`order-card-container ${isSelected? 'selected': ''}`} onClick={() => onSelectProduct(product)}>
            <h3 className="order-card-title">
                {product.name}
            </h3>
            <img src={product.imageUri} alt={product.name} className="order-card-image" />
            <h3 className="order-card-price">
                {formatprice(product.price)}
            </h3>
            <div className="order-card-description">
                <h3>Descrição</h3>
                <p>
                   {product.description}
                </p>
            </div>
        </div>
    )
}
export default ProductCard;