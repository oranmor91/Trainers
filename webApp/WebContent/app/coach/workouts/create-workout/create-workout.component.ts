import { EXERCISE } from '../../../Model/exercise.model';
import { WORKOUT } from '../../../Model/workout.model';
import { DataService } from '../../../Services/data/data.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-workout',
  templateUrl: './create-workout.component.html',
  styleUrls: ['./create-workout.component.css']
})
export class CreateWorkoutComponent implements OnInit {

  workout:WORKOUT = new WORKOUT();
  exercise:EXERCISE[]=[];
  
 constructor(private dataService:DataService,
              private router: Router) { }

 ngOnInit() {
   this.getExercises();
  }

  getExercises(){
    this.dataService.getCoachExercise('')
    .subscribe((data)=>{   
      },(err)=>{
        console.log(err)
      },()=>{
        console.log('done')
      })
    
  }
  
  saveWorkout(){
        this.dataService.createNewWorkout(this.workout)
      .subscribe((data)=>{
        this.router.navigate(['workouts']);      
      },(err)=>{
        console.log(err)
      },()=>{
        console.log('done')
      })
    
        
  }
}
