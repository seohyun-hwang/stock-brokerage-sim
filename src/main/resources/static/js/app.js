function transferToSpringBoot() {
    fetch('api/getFromHTML', {
        method: 'POST',
        headers: {
        body.JSON.stringify({
        })
        .then(response => response.json())
        .then(data => {
        console.log('Success', data);
        })
        .catch(error) => {
            console.error('Error: ', error);
        }
        }
    });
}