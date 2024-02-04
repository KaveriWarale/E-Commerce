
function addToCart(pID, pName, pPrice) {
	let cart = localStorage.getItem("cart");
	if (cart == null) {
		let products = [];
		let product = { productId: pID, productName: pName, productQuantity: 1, productPrice: pPrice }
		products.push(product);
		localStorage.setItem("cart", JSON.stringify(products));
		console.log("Added First Time")
	}
	else {

		let pcart = JSON.parse(cart);
		let oldProduct = pcart.find((item) => item.productId == pID);
		console.log(oldProduct)
		if (oldProduct) {

			oldProduct.productQuantity = oldProduct.productQuantity + 1;
			pcart.map((item) => {
				if (item.productId === oldProduct.productId) {
					item.productQuantity = oldProduct.productQuantity;
				}
			})
			localStorage.setItem("cart", JSON.stringify(pcart));
			console.log("Increased Quantity")
		}
		else {
			let product = { productId: pID, productName: pName, productQuantity: 1, productPrice: pPrice }
			pcart.push(product);
			localStorage.setItem("cart", JSON.stringify(pcart));
		}
	}
	updateCart();
}
//Update Cart
function updateCart() {
	let cartString = localStorage.getItem("cart");
	let cart = JSON.parse(cartString);
	if (cart == null || cart.length == 0) {
		console.log("Cart is Empty");
		localStorage.clear();
		$(".cart-items").html("( 0 )");
		$(".cart-body").html("<h5>Your Cart is Empty..</h5>");
		$(".checkout-button").attr('disabled', true);
	}
	else {
		console.log(cart)
		$(".cart-items").html(`(${cart.length})`);
		let table = `
		<form>
		<table class='table'>
			<thead>
			<tr>
					<th>Item</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Total Price</th>
					<th>Action</th>
			</tr>
			</thead>
		`;
		let totalPrice = 0;
		cart.map((item) => {
			table += `
				<tr>
				<td>${item.productName}</td>
				<td>${item.productPrice}</td>
				<td class='text-center'><b>
				${item.productQuantity}</b>
				
				<button class='button-remove' onClick='increaseQuantity(${item.productId})'>
			<img src='images/plus.png' width='20px' height='20px'  border='0' class='ml-2' />
			</button>
			
			
			<button class='button-remove' onClick='decreaseQuantity(${item.productId})'>
      		<img src='images/minus.png' width='20px' height='20px'  border='0' />
      		</button>
				
				</td>
				<td>${item.productQuantity * item.productPrice}</td>
				<td>
				<button class='button-remove' onClick='deleteItemFromCart(${item.productId})'>
        		<img src='images/delete-button.png' width='20px' height='20px'  border='0' />
      			</button>
				</td>
				</tr>
				`
			totalPrice += item.productPrice * item.productQuantity;

		})
		table = table + `<tr><td class='text-right m-5' colspan='5'><h5>Total Price: ${totalPrice}</h5> 
		</td></tr></table></form>`
		$(".cart-body").html(table);
		$(".checkout-button").removeAttr('disabled');

	}
}

$(document).ready(function() {
	updateCart();
})

function deleteItemFromCart(pid) {
	let cart = JSON.parse(localStorage.getItem('cart'));
	let newCart = cart.filter((item) => item.productId != pid)
	localStorage.setItem('cart', JSON.stringify(newCart))
	updateCart();
}

function increaseQuantity(pID) {

	let cart = JSON.parse(localStorage.getItem('cart'));
	let oldProduct = cart.find((item) => item.productId == pID);
	console.log(oldProduct)
	if (oldProduct) {

		oldProduct.productQuantity = oldProduct.productQuantity + 1;
		cart.map((item) => {
			if (item.productId === oldProduct.productId) {
				item.productQuantity = oldProduct.productQuantity;
			}
		})
		localStorage.setItem("cart", JSON.stringify(cart));
		console.log("Increased Quantity")
	}

	updateCart();
}

function decreaseQuantity(pID) {
	let cart = JSON.parse(localStorage.getItem('cart'));
	let oldProduct = cart.find((item) => item.productId == pID);

	if (cart == null || cart.length == 0) {
		let newCart = cart.filter((item) => item.productId != pID)
		localStorage.setItem('cart', JSON.stringify(newCart))
		console.log("Cart is null")
		updateCart();
	}
	else if (oldProduct.productQuantity == 0) {
		let newCart = cart.filter((item) => item.productId != pID)
		localStorage.setItem('cart', JSON.stringify(newCart))
		console.log("Quantity is 0")
		updateCart();
	}
	else {
		oldProduct.productQuantity = oldProduct.productQuantity - 1;
		console.log("Decreased Quantity")
	}

	localStorage.setItem('cart', JSON.stringify(cart));

	updateCart();
}
