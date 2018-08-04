import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {DataService} from "../../../Services/data/data.service";
import {PROGRAM} from "../../../Model/program.model";
import {EXERCISE} from "../../../Model/exercise.model";
import {WORKOUT} from "../../../Model/workout.model";
import {RM_DATA} from "../../../Model/rmData.model";

@Component({
  selector: 'app-rm',
  templateUrl: './rm.component.html',
  styleUrls: ['./rm.component.css']
})
export class RmComponent implements OnInit {
  program:PROGRAM;
  exercises:EXERCISE[]=[];
  private workoutName: string;

  constructor(private dataService:DataService,
              private router: Router) {

  }
  ngOnInit() {
    this.getTrainerProgram();
    this.workoutName = this.program.data.workouts[0].name;
    this.exercises = this.program.data.workouts[0].exercises;
  }

  private getTrainerProgram() {
    this.dataService.getProgram(Number(this.dataService.profile.id))
      .subscribe((data)=> {
          this.program = <PROGRAM> data;
      },(err)=>{
        console.log(err)
      },()=>{
        console.log('done')
      })
  }

  showExercise(rm:RM_DATA) {
    this.workoutName = rm.workout.name;
    this.program.data.workouts.forEach((ctrl: WORKOUT) => {
      if(ctrl.name === rm.workout.name){
        this.exercises = ctrl.exercises;
      }
    });
  }

  checkIfAllFilled(){
    this.program.data.workouts.forEach((wo: WORKOUT) => {
      wo.exercises.forEach((ex: EXERCISE) => {
        if(ex.weight === null){
          return false;
        }
      });
    });
    return true;
  }

  saveRm(){
    this.program.data.workouts.forEach((wo: WORKOUT) => {
      wo.exercises.forEach((ex: EXERCISE) => {
       this.program.rmData.forEach((rm: RM_DATA) => {
          if(rm.workout.name === wo.name && rm.exercise.exercise.name === ex.name) {
            rm.data = ex.weight;
            ex.weight = null;
          }
        });
      });
    });

    this.dataService.saveRM(this.program)
      .subscribe((data)=> {
      },(err)=>{
        console.log(err)
      },()=>{
        console.log('done')
      })

  }
}
