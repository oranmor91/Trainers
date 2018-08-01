import { TRAINER } from '../../Model/trainer.model';
import { DataService } from '../../Services/data/data.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-trainers',
  templateUrl: './trainers.component.html',
  styleUrls: ['./trainers.component.css']
})
export class TrainersComponent implements OnInit {

  trainers:TRAINER[]=[];

  constructor(private dataService:DataService,
              private router: Router) { }

  ngOnInit() {
    this.getTrainers()
  }

  getTrainers(){
   this.dataService.getTrainers(this.dataService.profile.id)
  .subscribe((data)=>{
  this.trainers = <TRAINER[]> data;
 },(err)=>{
    console.log(err)
  },()=>{
    console.log('done')
  })
  }

  createTrainer(){
  this.router.navigate(['create-trainer']);
  }

  editTrainer(id:number){
    this.router.navigate([`/edit-trainer/${id}`]);
  }

   removeTrainer(id:number){
    this.dataService.removeTrainer(id)
   .subscribe((data)=>{
  },(err)=>{
     console.log(err)
   },()=>{
     console.log('done')
   })
  }
}
