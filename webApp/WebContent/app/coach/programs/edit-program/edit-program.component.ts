import { PROGRAM } from '../../../Model/program.model';
import { WORKOUT } from '../../../Model/workout.model';
import { DataService } from '../../../Services/data/data.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit-program',
  templateUrl: './edit-program.component.html',
  styleUrls: ['./edit-program.component.css']
})
export class EditProgramComponent implements OnInit {
  programId:string;
 
 // workouts2:WORKOUT[]=[{workoutId:1, workoutName:'b', exercises:[]}];
 // workouts:WORKOUT[]=[{workoutId:1, workoutName:'b', exercises:[]}, {workoutId:2, workoutName:'c', exercises:[]}];
 // program:PROGRAM={numOfExercises:1,programId:1,programName:'a',programNote:'',programTarget:'',workouts:this.workouts2};
  
  workouts:WORKOUT[]=[];
  program:PROGRAM;
  
  arr:number[]=[];
  
  constructor(private dataService:DataService,
              private router: Router, 
              private route: ActivatedRoute) {
    this.programId = route.snapshot.params['id'];
  
  }

  ngOnInit() {
    this.getProgram()
    this.getWorkouts()
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
    this.dataService.getWorkouts(this.dataService.profile.id)
    .subscribe((data)=>{
    this.workouts = <WORKOUT[]> data;
   },(err)=>{
      console.log(err)
    },()=>{
      console.log('done')
    }) 
  }
  
  checkIfExisted(w:WORKOUT){
    console.log(w);
    console.log(this.program);
    if(!this.program.workouts || this.workouts.length == 0){
      console.log('no workouts found');
      return false;
    }
    
    this.arr = this.program.workouts.map(workout => workout.workoutId); 
    
    console.log(this.arr);
    
    if(this.arr.includes(w.workoutId)) {
       console.log('return true');
        return true;
    } else {
      console.log('return false');
      return false;
    }      
  }
  
  saveProgram(pro:PROGRAM){
      this.dataService.createNewProgram(this.dataService.profile.id, pro)
    .subscribe((data)=>{
   },(err)=>{
      console.log(err)
    },()=>{
      console.log('done')
    }) 
  }


}
