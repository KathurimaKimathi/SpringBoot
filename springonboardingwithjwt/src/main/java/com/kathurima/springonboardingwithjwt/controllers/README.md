## Summary of the payload
– Requests:

LoginRequest: { username, password }
SignupRequest: { username, email, password }

– Responses:

JwtResponse: { token, type, id, username, email, roles }
MessageResponse: { message }

## Controller for Authentication

This controller provides APIs for register and login actions.

- `/api/auth/signup`

check existing username/email
create new User (with ROLE_USER if not specifying role)
save User to database using UserRepository

- `/api/auth/signin`

authenticate { username, pasword }
update SecurityContext using Authentication object
generate JWT
get UserDetails from Authentication object
response contains JWT and UserDetails data