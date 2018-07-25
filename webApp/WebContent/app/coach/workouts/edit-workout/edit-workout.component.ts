import { EXERCISE } from '../../../Model/exercise.model';
import { WORKOUT } from '../../../Model/workout.model';
import { DataService } from '../../../Services/data/data.service';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-edit-workout',
  templateUrl: './edit-workout.component.html',
  styleUrls: ['./edit-workout.component.css']
})
export class EditWorkoutComponent implements OnInit {
    workoutId:string;
    workout:WORKOUT;
    exercises:EXERCISE[]=[]
    arr:number[]=[];
    
    constructor(private dataService:DataService,
              private router: Router, 
              private route: ActivatedRoute) {
    this.workoutId = route.snapshot.params['id'];
  
  }
  
  ngOnInit() {
    this.getWorkout()
    this.getExercises() 
  }

  getWorkout(){
      this.dataService.getWorkout(this.workoutId)
    .subscribe((data)=>{
    this.workout = <WORKOUT> data;
   },(err)=>{
      console.log(err)
    },()=>{
      console.log('done')
    }) 
  }
  
    getExercises() {
    this.dataService.getExercises(this.dataService.profile.id)
    .subscribe((data)=>{
    this.exercises = <EXERCISE[]> data;
   },(err)=>{
      console.log(err)
    },()=>{
      console.log('done')
    }) 
  }
  
  checkIfExisted(e:EXERCISE){
    console.log(e);
    console.log(this.workout);
    if(!this.workout.exercises || this.exercises.length == 0){
      console.log('no exercises found');
      return false;
    }
    
    this.arr = this.workout.exercises.map(exercise => exercise.exerciseId); 
    
    console.log(this.arr);
    
    if(this.arr.includes(e.exerciseId)) {
       console.log('return true');
        return true;
    } else {
      console.log('return false');
      return false;
    }      
  }
  
  saveProgram(){
    
  }
}
