import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {EXERCISE} from "../../../Model/exercise.model";
import {DataService} from "../../../Services/data/data.service";
import {PROGRAM} from "../../../Model/program.model";
import {WORKOUT} from "../../../Model/workout.model";

@Component({
  selector: 'app-current-program',
  templateUrl: './current-program.component.html',
  styleUrls: ['./current-program.component.css']
})
export class CurrentProgramComponent implements OnInit {


  programId:string;
  program:PROGRAM;
  exercises:EXERCISE[]=[];
  workout:WORKOUT[]=[];
  workoutName:string;

  constructor(private dataService:DataService) {

  }

  ngOnInit() {
    this.getProgram();
    //this.getWorkouts();
    this.workoutName = this.program.data.workouts[0].name;
    this.exercises = this.program.data.workouts[0].exercise;
  }

  getProgram() {
    this.dataService.getProgramForUser()
      .subscribe((data)=>{
        this.program = <PROGRAM> data;
      },(err)=>{
        console.log(err)
      },()=>{
        console.log('done')
      })
  }


//  getWorkouts() {
//    this.dataService.getWorkout(String(this.program.id))
//    .subscribe((data)=>{
//    this.workout = <WORKOUT[]> data;
//   },(err)=>{
//      console.log(err)
//    },()=>{
//      console.log('done')
//    })
//  }

  showExercise(w:WORKOUT) {
    this.workoutName = w.name;
    this.exercises = w.exercise;
  }
}
