import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ACCOUNT} from "../../Model/acount.model";
import { EXERCISE } from '../../Model/exercise.model';
import {TRAINER} from "../../Model/trainer.model";
import {PROFILE} from "../../Model/profile.model";
import { PROGRAM } from '../../Model/program.model';
import { WORKOUT } from '../../Model/workout.model';

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

  createNewProgram(id:string, program:PROGRAM) {
    return this.http.post(`${this.baseURL}{{id}}/createProgram`, program)
  }

  getPrograms(id:string) {
    return this.http.get(`${this.baseURL}/{{id}}/getProgram`)
  }

  removeProgram(id:number) {
    return this.http.post(`${this.baseURL}/removeProgram`, id)
  }

  getProgram(id:number) {
    return this.http.post(`${this.baseURL}/getProgram`, id)
  }

  createNewWorkout(id:string, workout:WORKOUT) {
    return this.http.post(`${this.baseURL}/{{id}}/createWorkout`, workout)
  }

  getWorkouts(id:string){
     return this.http.get(`${this.baseURL}/{{id}}/getWorkouts`)
  }

  getWorkout(id:string){
    return this.http.post(`${this.baseURL}/getWorkout`, id)
  }

  removeWorkout(id:number) {
    return this.http.post(`${this.baseURL}/removeWorkout`, id)
  }

  getExercises(id:string){
     return this.http.get(`${this.baseURL}/{{id}}/getExercises`)
  }

  getExercise(id:string){
    return this.http.post(`${this.baseURL}/getExercise`, id)
  }

  removeExercise(id:number) {
     return this.http.post(`${this.baseURL}/removeExercise`, id)
  }

  createNewExercise(exercise:EXERCISE) {
    return this.http.post(`${this.baseURL}/createExercise`, exercise)
  }

  getCoachExercise(id:string) {
    return this.http.get(`${this.baseURL}/{{id}}/getExercise`)
  }


}
