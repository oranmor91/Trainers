import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {ACCOUNT} from "../../Model/acount.model";
import { EXERCISE } from '../../Model/exercise.model';
import {TRAINER} from "../../Model/trainer.model";
import {PROFILE} from "../../Model/profile.model";
import { PROGRAM_DEF } from '../../Model/programDef.model';
import { WORKOUT } from '../../Model/workout.model';
import {PROGRAM} from "../../Model/program.model";

@Injectable()
export class DataService {

profile:PROFILE;
  baseURL:string='http://localhost:8080';
  constructor(private http: HttpClient) {

  }

  login(account:ACCOUNT){
    return this.http.post(`${this.baseURL}/public/login`, account);
  }

  register(trainer:TRAINER) {
    return this.http.post(`${this.baseURL}/public/register`, trainer)
  }

  createNewProgram(id:string, program:PROGRAM_DEF) {
    return this.http.post(`${this.baseURL}/admin/program`, program)
  }

  getPrograms(id:string) {
      return this.http.get(`${this.baseURL}/admin/program`)
  }

  getProgram(id:string) {
    return this.http.post(`${this.baseURL}/admin/program`, id)
  }

  removeProgram(id:number) {
    return this.http.delete(`${this.baseURL}/admin/program/${id}`)
  }

  getUserProgram(id:number) {
    return this.http.get(`${this.baseURL}/admin/program/userProgram/${id}`)
  }

  createNewWorkout(id:string, workout:WORKOUT) {
    return this.http.post(`${this.baseURL}/admin/workout`, workout)
  }

  getWorkouts(id:string){
     return this.http.get(`${this.baseURL}/admin/workout`)
  }

  getWorkout(id:string){
    return this.http.get(`${this.baseURL}/admin/workout/${id}`)
  }

  removeWorkout(id:number) {
    return this.http.delete(`${this.baseURL}/admin/workout/${id}`)
  }

  getExercises(id:string){
     return this.http.get(`${this.baseURL}/admin/exercise`)
  }

  getExercise(id:string){
    return this.http.post(`${this.baseURL}/admin/exercise`, id)
  }

  setExercise(exercise:EXERCISE){
    return this.http.post(`${this.baseURL}/admin/exercise`, exercise)
  }

  removeExercise(id:number) {
     return this.http.delete(`${this.baseURL}/admin/exercise/${id}`)
  }

  createNewExercise(exercise:EXERCISE) {
    return this.http.post(`${this.baseURL}/admin/exercise`, exercise)
  }

  createNewTrainer(trainer:TRAINER) {
    return this.http.post(`${this.baseURL}/admin/user`, trainer)
  }

  getTrainers(id: string) {
    return this.http.get(`${this.baseURL}/admin/user`)
  }

  removeTrainer(id: number) {
    return this.http.delete(`${this.baseURL}/admin/user/${id}`)
  }

  getTrainerProfile(trainerId: string) {
    return this.http.get(`${this.baseURL}/admin/user/${trainerId}`)
  }

  setUserProgram(trainerId:string, programId:number) {
    return this.http.get(`${this.baseURL}/admin/user/${trainerId}/${programId}`)
  }

  getProfile() {
    return this.http.get(`${this.baseURL}/user`)
  }

  saveRM(program:PROGRAM) {
      return this.http.post(`${this.baseURL}/user/rm`, program)
  }
}
