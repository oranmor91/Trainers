import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ACCOUNT} from "../../Model/acount.model";
import {TRAINER} from "../../Model/trainer.model";
import {PROFILE} from "../../Model/profile.model";

@Injectable()
export class DataService {

profile:PROFILE;
  baseURL:string='http://localhost:8080';
  constructor(private http: HttpClient) {

  }

  login(account:ACCOUNT){
    return this.http.post(`${this.baseURL}/login`, account);
  }

  register(trainer:TRAINER) {
    return this.http.post(`${this.baseURL}/trainer`, trainer)
  }

  createNewTrainer(trainer:TRAINER) {
    return this.http.post(`${this.baseURL}/trainer`, trainer)
  }
}
