export interface User{
    userId?: number;  // made the user id optional so we can send the registration form data without the id
    fname: string;
    lname: string;
    email: string;
    role: string;
    username: string;
    password?: string; // made the password field optional so when we get back the user object server can send it
                        //without the password
}
