import { EXERCISE } from '../../../Model/exercise.model';
import { DataService } from '../../../Services/data/data.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-exercise',
  templateUrl: './create-exercise.component.html',
  styleUrls: ['./create-exercise.component.css']
})
export class CreateExerciseComponent implements OnInit {

   exercise:EXERCISE = new EXERCISE();
  
 constructor(private dataService:DataService,
              private router: Router) { }

  ngOnInit() {
  }

  saveExercise(){
        this.dataService.createNewExercise(this.exercise)
      .subscribe((data)=>{
        this.router.navigate(['exercises']);      
      },(err)=>{
        console.log(err)
      },()=>{
        console.log('done')
      })
    
        
  }
}
