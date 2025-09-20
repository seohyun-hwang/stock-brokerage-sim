let fetchedPrice = 0.00;

// fetching a stock price from the database
export async function stockPrice_presentDay(): Promise<number> {

    return fetchedPrice;
}


const submitButton_indexHTML = document.getElementById('stock-option-submission');

// Add an event listener to the button
if (submitButton_indexHTML) {
  submitButton_indexHTML.addEventListener('click', () => {
    if () { // CONDITION NEEDED HERE
        window.location.href = 'stock-display.ts';
    }
    else {
        window.alert('You need to specify your stock, year, month, and date!');
    }
  });
}
