const roles = {
    admin: [{ action: "*", resource: "*" }],
    user : [{ action: ['read', ], resource: "community:*" }],
}

export default roles
