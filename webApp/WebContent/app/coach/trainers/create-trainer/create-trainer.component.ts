import { TRAINER } from '../../../Model/trainer.model';
import { DataService } from '../../../Services/data/data.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-trainer',
  templateUrl: './create-trainer.component.html',
  styleUrls: ['./create-trainer.component.css']
})
export class CreateTrainerComponent implements OnInit {

trainer:TRAINER = new TRAINER();

 public gender : any = TRAINER;

  constructor(private dataService:DataService,
              private router: Router) { }

  ngOnInit() {
  }

  createNewTrainer(){
   this.router.navigate(['trainers']);
  }
//  createNewTrainer(){
//    this.dataService.createNewTrainer(this.trainer)
//      .subscribe((data)=>{
//        console.log(data)

//        this.router.navigate(['trainers']);
//      },(err)=>{
//        console.log(err)
//      },()=>{
//        console.log('done')
//      })
//  }
}
