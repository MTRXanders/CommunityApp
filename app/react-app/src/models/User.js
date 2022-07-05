export default class User {
    constructor(
            name = '',
            lastName = '',
            address = '',
            email = '', 
            password = '',
            telephone = '',
            roles = [], 
            claims = []
        ) {
        this.id = '';
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.telephone = telephone;
        this.password = password;
        this.role = roles;
        this.claim = claims;
    }
}