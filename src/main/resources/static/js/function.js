/**
 * 
 */

 function incrementQuantity(button) {
    var quantityInput = button.parentElement.querySelector('input[type="number"]');
    quantityInput.value = parseInt(quantityInput.value) + 1;
}

function decrementQuantity(button) {
    var quantityInput = button.parentElement.querySelector('input[type="number"]');
    if (parseInt(quantityInput.value) > 1) {
        quantityInput.value = parseInt(quantityInput.value) - 1;
    }
}

function addToCart(button) {
    var quantityInput = button.parentElement.querySelector('input[type="number"]');
    var quantity = quantityInput.value;
    alert("Added " + quantity + " pizza(s) to the cart!");
}