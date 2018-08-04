import { PROGRAM_DEF } from '../../../Model/programDef.model';
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

  program:PROGRAM_DEF = new PROGRAM_DEF();
  workouts:WORKOUT[]=[];
  temp:number[]=[];
  arr2:number[]=[];

 constructor(private dataService:DataService,
              private router: Router) { }

  ngOnInit() {
   this.getWorkout();
  }

  getWorkout(){
      this.dataService.getWorkouts(this.dataService.profile.id)
      .subscribe((data)=>{
      this.workouts = <WORKOUT[]> data;
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

  saveProgram(){
      this.program.workouts = this.temp;
         this.dataService.createNewProgram(this.dataService.profile.id, this.program)
      .subscribe((data)=>{
        this.router.navigate(['programs']);
      },(err)=>{
        console.log(err)
      },()=>{
        console.log('done')
      })


  }
}
