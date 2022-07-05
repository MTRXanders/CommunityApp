
const AuthProvider = {
    login: (userName, password) => {
        const request = new Request(
            'http://localhost:8080/api/login', {
                method: 'POST',
                body:JSON.stringify({userName, password}),
                headers: new Headers({'Content-Type': 'application/json'}),
            })
            return fetch(request)
            .then(response => {
                if (response.status < 200 || response.status >= 300) {
                    throw new Error(response.statusText)
                }
                return response.json()
            })
            .then(auth => {
                localStorage.setItem('auth', JSON.stringify(auth))
            })
            .catch(error => {
                throw new Error('Login failed')
            })
            //add httpOnly cookie on serverside to provide defence from xss atack
    },
    logout: () => {
        localStorage.removeItem('auth')
        return Promise.resolve('/admin-login');
    },
    checkError: (error) => {
        const status = error.status;
        if (status === 401 || status === 403) {
            localStorage.removeItem('auth');
            return Promise.reject();
        }
        return Promise.resolve()
    },
    checkAuth: () => {
        localStorage.getItem('auth') 
        ? Promise.resolve() : 
        Promise.reject({message: 'logon.required'});
    },
    getIdentity : () => {
        try {
            const { id, fullName, avatar } = JSON.parse(localStorage.getItem('auth'));
            return Promise.resolve({ id, fullName, avatar });
        } catch (error) {
            return Promise.reject(error);
        }
    },
    getPermissions: () => {
        const role = localStorage.getItem('permissions');
        return role ? Promise.resolve(role) : Promise.reject();
    },
}

export default AuthProvider;