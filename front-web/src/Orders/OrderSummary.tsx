import { types } from "util";
import { formatprice } from "./helpers";

type Props={
    amount: number;
    totalPrice: number;
    onSubmit: ()=> void;
}

function OrderSummary({amount, totalPrice, onSubmit}: Props){

    return(
        <div className="order-summary-container">
            <div className="order-summary-content">
                <span className="amount-selected-container">
                    <strong className="amount-selected">{amount}</strong>
                    Pedidos Selecionados
                    <span className='order-summary-total'>
                        <strong className="amount-selected">{formatprice(totalPrice)}</strong>
                        Valor Total
                    </span>
                </span>
                <button 
                    className="order-summary-make-order"
                    onClick={onSubmit}
                >Fazer Pedido</button>
            </div>
        </div>
    )
}
export default OrderSummary;