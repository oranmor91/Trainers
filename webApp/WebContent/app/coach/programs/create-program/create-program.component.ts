import { PROGRAM } from '../../../Model/program.model';
import { WORKOUT } from '../../../Model/workout.model';
import { DataService } from '../../../Services/data/data.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-program',
  templateUrl: './create-program.component.html',
  styleUrls: ['./create-program.component.css']
})
export class CreateProgramComponent implements OnInit {

  program:PROGRAM = new PROGRAM();
  workouts:WORKOUT[]=[];
  
 constructor(private dataService:DataService,
              private router: Router) { }

  ngOnInit() {
   this.getWorkout();    
  }

  getWorkout(){
      this.dataService.getWorkouts(this.dataService.profile.id)
      .subscribe((data)=>{
        
      this.workouts = <WORKOUT[]> data;
        
       this.router.navigate(['programs']);      
      },(err)=>{
        console.log(err)
      },()=>{
        console.log('done')
      })
    
  }
  
  
  saveProgram(pro:PROGRAM){
         this.dataService.createNewProgram(this.dataService.profile.id, pro)
      .subscribe((data)=>{
        this.router.navigate(['programs']);      
      },(err)=>{
        console.log(err)
      },()=>{
        console.log('done')
      })
    
        
  }
}
