import { WORKOUT } from '../../Model/workout.model';
import { DataService } from '../../Services/data/data.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-workouts',
  templateUrl: './workouts.component.html',
  styleUrls: ['./workouts.component.css']
})
export class WorkoutsComponent implements OnInit {

  workouts:WORKOUT[]=[];
  
 constructor(private dataService:DataService,
              private router: Router) { }

 ngOnInit() {
   this.getWorkouts()
  }

  getWorkouts(){
 //    this.dataService.getWorkuts('1111')
 //   .subscribe((data)=>{
 //   this.workout = <WORKOUT[]> data;
//   },(err)=>{
//      console.log(err)
//    },()=>{
//      console.log('done')
//    })
  }
  
  createWorkout(){
    this.router.navigate(['create-workout']);
  }
  
  editWorkout(id:number){
  }
  
  removeWorkout(id:number){
 //    this.dataService.removeWorkout(id)
 //   .subscribe((data)=>{
//   },(err)=>{
//      console.log(err)
//    },()=>{
//      console.log('done')
//    })
  }
}