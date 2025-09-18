function transferSelection_toJavaBackend() {
    const selectedValue = document.getElementById('').value;

    fetch('/api/selectStock'), {
        method: 'GET',
        headers: {
            'Content-Type': 'app/json'
        },
        body:
    }
}

function fetchPrice(ticker) {
    fetch(`/api/stocks/${ticker}`)
        .then(response => response.json())
        .then(price => {
            document.querySelector(".stock-display-graph").innerText =
                ticker + " : $" + price.toFixed(2);
        })
        .catch(error => console.error("Error fetching price:", error));
}

function selectStock(ticker) {
    setInterval(() => fetchPrice(ticker), 500);
}