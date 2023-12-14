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
        pizzaName: pizzaName,
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
    .then(response => {
        console.log(response.status); // Log the HTTP status code
        return response.text(); // Retrieve the response as text
    })
    .then(data => {
        // Log the response as text
        // Check if the response contains HTML
        if (data.includes('<html') || data.includes('<!DOCTYPE')) {
            // Handle the HTML response, e.g., display it in a modal or alert
           
        } else {
            // Parse the JSON response
            let jsonData = JSON.parse(data);
            console.log(jsonData);
            // Handle the response, e.g., show a success message

        }
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
    document.getElementById("price").value = totalSelectedPrice.toFixed(2);

}

//function submitForm() {
//    // Retrieve the values from the form elements
//   
//    let pizzaName = document.getElementById("pizzaName").value;
//    let base = document.getElementById("base").value;
//
//    // Retrieve selected cheese options
//    let selectedCheeses = Array.from(document.querySelectorAll('input[name="cheese"]:checked')).map(cheese => cheese.value);
//
//    // Retrieve selected toppings
//    let selectedToppings = Array.from(document.getElementById("exampleSelect2").selectedOptions).map(topping => topping.value);
//
//    // Retrieve the calculated price
//    let finalPrice = document.getElementById("price").value;
//	
//    // Display the retrieved information (you can customize this part based on your needs)
//    console.log("Pizza Name: " + pizzaName);
//    console.log("Base: " + base);
//    console.log("Selected Cheeses: " + selectedCheeses);
//    console.log("Selected Toppings: " + selectedToppings);
//    console.log("Final Price: " + finalPrice);
//
//    // Add any additional logic or send the data to the server as needed
//
//    // Optionally, you can submit the form programmatically
//   // document.getElementById("custom_pizza").submit();
//}

const form = document.getElementById('custom_pizza');


function handleSubmit(event){

    event.preventDefault();

    const pizzaName = document.getElementById("pizzaName").value;
    const base = document.getElementById("base").value;
	 let selectedCheeses = Array.from(document.querySelectorAll('input[name="cheese"]:checked')).map(cheese => cheese.value);
  	let selectedToppings = Array.from(document.getElementById("exampleSelect2").selectedOptions).map(topping => topping.value);
	let finalPrice = document.getElementById("price").value;
     finalPrice = parseFloat(finalPrice.trim());
	  // Create a data object with the pizza information
    let pizzaData = {
        pizzaName: pizzaName,
        quantity: 1,
        price: finalPrice,
        base: base,
        ingredients: selectedToppings,
        fromages: selectedCheeses
    };

    // Make an Ajax request to add the pizza to the cart
    fetch('/cart/add', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(pizzaData)
    })
    .then(response => {
        console.log(response.status); // Log the HTTP status code
        return response.text(); // Retrieve the response as text
    })
    .then(data => {
        // Log the response as text
        // Check if the response contains HTML
        if (data.includes('<html') || data.includes('<!DOCTYPE')) {
            // Handle the HTML response, e.g., display it in a modal or alert
           
        } else {
            // Parse the JSON response
            let jsonData = JSON.parse(data);
            console.log(jsonData);
            // Handle the response, e.g., show a success message

        }
    })
    .catch(error => {
        console.error('Error:', error);
    });
 

  
    
  //  document.getElementById('colors-form').reset();
    
}

form.addEventListener('submit', handleSubmit);
