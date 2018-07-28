import { EXERCISE } from '../../../../Model/exercise.model';
import { PROGRAM } from '../../../../Model/program.model';
import { WORKOUT } from '../../../../Model/workout.model';
import { DataService } from '../../../../Services/data/data.service';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-trainer-program',
  templateUrl: './trainer-program.component.html',
  styleUrls: ['./trainer-program.component.css']
})
export class TrainerProgramComponent implements OnInit {


/*    exercises:EXERCISE[]=[{exerciseId:111, exerciseName:'a', mainMuscle:'legs', repeats:3, sets:2, note:'asas', weight:10},
    {exerciseId:222, exerciseName:'b', mainMuscle:'legs', repeats:3, sets:2, note:'asas', weight:20},
    {exerciseId:333, exerciseName:'c', mainMuscle:'legs', repeats:3, sets:2, note:'asas', weight:30}];

      exercises2:EXERCISE[]=[{exerciseId:111, exerciseName:'d', mainMuscle:'hand', repeats:3, sets:2, note:'asas', weight:40},
    {exerciseId:222, exerciseName:'e', mainMuscle:'hand', repeats:3, sets:2, note:'asas', weight:50},
    {exerciseId:333, exerciseName:'f', mainMuscle:'hand', repeats:3, sets:2, note:'asas', weight:60}];

  workout:WORKOUT[]=[{exercises:this.exercises,workoutId:111,workoutName:'a'}, {exercises:this.exercises2,workoutId:222,workoutName:'b'}];
  program:PROGRAM={numOfExercises:1,programId:1,programName:'a',programNote:'',programTarget:'',workouts:this.workout};*/

  programId:string;
  program:PROGRAM;
  exercises:EXERCISE[]=[];
  workoutName:string;

  constructor(private dataService:DataService,
              private router: Router,
              private route: ActivatedRoute) {
    this.programId = route.snapshot.params['id'];

  }

 ngOnInit() {
   this.getProgram();
   this.workoutName = this.program.workouts[0].workoutName;
   this.exercises = this.program.workouts[0].exercises;
  }

  getProgram() {
    this.dataService.getProgram(Number(this.programId))
    .subscribe((data)=>{
    this.program = <PROGRAM> data;
   },(err)=>{
      console.log(err)
    },()=>{
      console.log('done')
    })
  }

  showExercise(w:WORKOUT) {
    this.workoutName = w.workoutName;
    this.exercises=w.exercises;
  }
}
