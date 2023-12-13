/**
 * 
 */

 function incrementQuantity(button) {
    let quantityInput = button.parentElement.querySelector('input[type="number"]');
    quantityInput.value = parseInt(quantityInput.value) + 1;
}

function decrementQuantity(button) {
    let quantityInput = button.parentElement.querySelector('input[type="number"]');
    if (parseInt(quantityInput.value) > 1) {
        quantityInput.value = parseInt(quantityInput.value) - 1;
    }
}

//function to send the info to the back

function addToCart(button) {
	
	let quantityInput = button.parentElement.querySelector('input[type="number"]');
    let quantity = quantityInput.value;

    // Traverse the DOM to find the associated h5 element
    let cardBody = button.closest('.card-body');
    let h5Element = cardBody.querySelector('.card-title');
    let price = cardBody.querySelector('p.mt-2').textContent;
    // Get the text content of the h5 element
    let pizzaName = h5Element.textContent;
   
    console.log(pizzaName);
   	console.log(quantity);
    console.log(price);


 price = parseFloat(price.replace('€', '').trim());

    // Create a data object with the pizza information
    let pizzaData = {
        name: pizzaName,
        quantity: quantity,
        price: price
    };

    // Make an Ajax request to add the pizza to the cart
    fetch('/cart/add', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(pizzaData)
    })
    .then(response => response.json())
    .then(data => {
        // Handle the response, e.g., show a success message
        alert(data.message);
    })
    .catch(error => {
        console.error('Error:', error);
    });
    alert("Added " + quantity + " pizza(s) to the cart!");

}


function calculatePrice() {
    let selectedIngredients = Array.from(document.getElementById("exampleSelect2").selectedOptions);
   
    let totalSelectedPrice = 0;

    // Iterate through selected ingredients and sum their prices
    selectedIngredients.forEach(element => {
        let optionPrice = parseFloat(element.getAttribute("data-price"));
        totalSelectedPrice += optionPrice;
    });

    // Set the calculated price to the visible input field
    document.getElementById("price"+ "€").value = totalSelectedPrice.toFixed(2);

    // Set the calculated price to the hidden input field
    document.getElementById("hiddenPrice").value = totalSelectedPrice.toFixed(2);
}
