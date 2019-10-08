import { Injectable } from '@angular/core';
import {HttpClientService, User} from './http-client.service'

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private httpClientService: HttpClientService
    ) { }

    user: User[];

  authenticate(username, password) {
    if (username === "balcao" && password === "geral456") {
      sessionStorage.setItem('username', username)
      return true;
    } else {
      return false;
    }
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
    console.log(!(user === null))
    return !(user === null)
  }

  logOut() {
    sessionStorage.removeItem('username')
  }
}