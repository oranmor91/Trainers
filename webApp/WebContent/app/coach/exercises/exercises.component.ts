import { EXERCISE } from '../../Model/exercise.model';
import { DataService } from '../../Services/data/data.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-exercises',
  templateUrl: './exercises.component.html',
  styleUrls: ['./exercises.component.css']
})
export class ExercisesComponent implements OnInit {

  exercises:EXERCISE[]=[];
  
   constructor(private dataService:DataService,
              private router: Router) { }

  ngOnInit() {
    this.getExercises()
  }

  getExercises(){
 //    this.dataService.getExercises('1111')
 //   .subscribe((data)=>{
 //   this.exercises = <EXERCISE[]> data;
//   },(err)=>{
//      console.log(err)
//    },()=>{
//      console.log('done')
//    })
  }
  
  createExercise(){
    this.router.navigate(['create-exercise']);
  }
  
  editExercise(id:number){
  }

  removeExercise(id:number){
 //    this.dataService.removeExercise('1111')
 //   .subscribe((data)=>{
//   },(err)=>{
//      console.log(err)
//    },()=>{
//      console.log('done')
//    })
  }
}
