export  class RestRepository {
    /**
     * Get request with url
     * @param {String} url 
     */
    static get(url) {
        console.log("GET", url)
        return this.makeRequest('GET', url)
    }

    /**
     * 
     * @param {String} url 
     * @param {Object} data 
     * @returns Promise<Response> Response
     */
    static post(url, data) {
        console.log("POST", url, data)
        return this.makeRequest('POST', url, data);

    }
    
    /**
     * Put request with url
     * @param {String} url 
     * @param {Object} data 
     * @returns Promise<Response> Response
     */
    static put(url, data) {
        console.log("PUT", url, data)
        return this.request('PUT', url, data);
    }

    /**
     * Delete request with url
     * @param {String} url 
     */
    static delete(url) {
        console.log("DELETE", url)
        return this.request('DELETE', url);
    }

    /**
     * Asyncronous request Fetch APi with url 
     * @param {String} method 
     * @param {String} url 
     * @param {Object} data 
     * @returns Response
     */
    static async makeRequest(method, url, data) {
        let isBadRequest, 
        body = data,
        headers = new Headers()
        // Accept: 'application/json',
        // 'Content-Type': 'application/json',
        // 'Access-Control-Allow-Origin': '*',
        headers.append('Accept', 'Application/json')
        headers.append('Access-Control-Allow-Origin', '*')
        if (data) {
            if (typeof data === 'object') {
                headers.append('Content-Type', 'application/json')
                body = JSON.stringify(data)
            } else {
                headers.append('Content-Type', 'application/x-www-form-urlencoded')
            }
        }
        return await fetch(url, {
            method,
            headers,
            body,
            credentials: 'include'
        }).then(response => {
            isBadRequest = response.status >= 400 && response.status < 600

            let contentType = response.headers.get('content-type') 
            if (contentType && contentType.includes('application/json')) {
                return response.json()
            } else {
                return response.text()
            }
        }).catch(error => {
            let response = {
                is_error: isBadRequest,
                error_content: isBadRequest,
                content: isBadRequest ? null : error
            }
            console.log(response);
            return response;
        })
    }
}

