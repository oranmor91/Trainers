import { EXERCISE } from '../../../Model/exercise.model';
import { DataService } from '../../../Services/data/data.service';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-edit-exercise',
  templateUrl: './edit-exercise.component.html',
  styleUrls: ['./edit-exercise.component.css']
})
export class EditExerciseComponent implements OnInit {
    exerciseId:string;
    exercise:EXERCISE;

    constructor(private dataService:DataService,
              private router: Router,
              private route: ActivatedRoute) {
  this.route.params.subscribe( params => console.log(params));
  this.route.params.subscribe(params => this.definedId(params['id']));
  }

  definedId(id: string){
    this.exerciseId = id;
  }

  ngOnInit() {
    this.getExercise();
  }

  getExercise(){
    this.dataService.getExercise(this.exerciseId)
    .subscribe((data)=>{
    this.exercise = <EXERCISE> data;
   },(err)=>{
      console.log(err)
    },()=>{
      console.log('done')
    })
  }

  saveExercise(){
    this.dataService.getExercise(this.exerciseId)
    .subscribe((data)=>{
    this.router.navigate(['exercises']);
   },(err)=>{
      console.log(err)
    },()=>{
      console.log('done')
    })
  }
}
