import { PROGRAM } from '../../../Model/program.model';
import { WORKOUT } from '../../../Model/workout.model';
import { DataService } from '../../../Services/data/data.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-edit-program',
  templateUrl: './edit-program.component.html',
  styleUrls: ['./edit-program.component.css']
})
export class EditProgramComponent implements OnInit {
  programId:string;
 @ViewChild('editForm') editForm:NgForm;

/*  ex:EXERCISE;
  workout:WORKOUT[]=[{exercises:[this.ex],id:111,name:'a'},
    {exercises:[this.ex],id:222,name:'b'},
    {exercises:[this.ex],id:333,name:'c'}];
  workout2:WORKOUT[]=[{exercises:[this.ex],id:222,name:'b'}];
  program:PROGRAM={numOfExercises:1,programId:1,programName:'a',programNote:'',description:'',workouts:this.workout2};*/

  program:PROGRAM;
  workout:WORKOUT[]=[];
  temp:number[]=[];
  arr2:number[]=[];

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
    this.workout = <WORKOUT[]> data;
   },(err)=>{
      console.log(err)
    },()=>{
      console.log('done')
    })
  }

  checkIfExisted(w:WORKOUT){
    if(!this.program.workouts || this.program.workouts.length == 0){
      console.log('no workouts found');
      return false;
    }


    if(this.program.workouts.includes(w.id)) {
       //console.log('return true');
        return true;
    } else {
       //console.log('return false');
       return false;
    }
  }

  saveProgram(){
    this.program.workouts = this.temp.slice();
    this.temp = [];
    console.log(this.temp);
    console.log(this.program.workouts);
    location.reload();

      this.dataService.createNewProgram(this.dataService.profile.id, this.program)
    .subscribe((data)=>{
   },(err)=>{
      console.log(err)
    },()=>{
      console.log('done')
    })
  }


  onCheckChange($event, w:WORKOUT) {
    /* Selected */
    if($event.target.checked) {
      this.arr2 = this.temp.map(workout => workout);

      if (!this.arr2.includes(w.id)) {
      // Add a new control in the arrayForm
      this.temp.push(w.id);
      console.log('after push');
      console.log(this.temp);
      }
    }
    /* unselected */
    else{
      // find the unselected element
      let i: number = 0;
      this.temp.forEach((ctrl: number) => {
        if(ctrl == w.id) {
          // Remove the unselected element from the arrayForm
          this.temp[i] = 0;
          this.temp = this.temp.filter(workout => workout != 0);
          console.log('after remove');
          console.log(this.temp);
          return;
        }

        i++;
      });


    }
  }
}
