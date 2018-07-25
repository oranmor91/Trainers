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

  programId:string;
  program:PROGRAM;
  exercises:EXERCISE[]=[]
  
  constructor(private dataService:DataService,
              private router: Router, 
              private route: ActivatedRoute) {
    this.programId = route.snapshot.params['id'];
  
  }

 ngOnInit() {
   this.getProgram();
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

  
  
  
  getExercise(w:WORKOUT) {
    this.exercises=w.exercises;
  }
}
