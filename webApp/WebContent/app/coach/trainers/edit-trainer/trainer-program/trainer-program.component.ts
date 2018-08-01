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


/*    exercises:EXERCISE[]=[{id:111, name:'a', primaryMuscle:'legs', numOfIntervals:3, numOfSets:2, comment:'asas', weight:10},
    {id:222, name:'b', primaryMuscle:'legs', numOfIntervals:3, numOfSets:2, comment:'asas', weight:20},
    {id:333, name:'c', primaryMuscle:'legs', numOfIntervals:3, numOfSets:2, comment:'asas', weight:30}];

      exercises2:EXERCISE[]=[{id:111, name:'d', primaryMuscle:'hand', numOfIntervals:3, numOfSets:2, comment:'asas', weight:40},
    {id:222, name:'e', primaryMuscle:'hand', numOfIntervals:3, numOfSets:2, comment:'asas', weight:50},
    {id:333, name:'f', primaryMuscle:'hand', numOfIntervals:3, numOfSets:2, comment:'asas', weight:60}];

  workout:WORKOUT[]=[{exercises:this.exercises,id:111,name:'a'}, {exercises:this.exercises2,id:222,name:'b'}];
  program:PROGRAM={numOfExercises:1,programId:1,programName:'a',programNote:'',description:'',workouts:this.workout};*/

  programId:string;
  program:PROGRAM;
  exercises:EXERCISE[]=[];
  workout:WORKOUT[]=[];
  workoutName:string;

  constructor(private dataService:DataService,
              private router: Router,
              private route: ActivatedRoute) {
    this.programId = route.snapshot.params['id'];

  }

 ngOnInit() {
   this.getProgram();
   this.getWorkouts();
   this.workoutName = this.workout[0].name;
   this.exercises = this.workout[0].exercises;
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


  getWorkouts() {
    this.dataService.getWorkout(String(this.program.programId))
    .subscribe((data)=>{
    this.workout = <WORKOUT[]> data;
   },(err)=>{
      console.log(err)
    },()=>{
      console.log('done')
    })
  }

  showExercise(w:WORKOUT) {
    this.workoutName = w.name;
    this.exercises = w.exercises;
  }
}
