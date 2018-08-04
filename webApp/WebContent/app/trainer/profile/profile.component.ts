import { TRAINER } from '../../Model/trainer.model';
import { DataService } from '../../Services/data/data.service';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  trainer:TRAINER;
  
    constructor(private dataService:DataService,
              private router: Router,
              private route: ActivatedRoute) {

  }

  ngOnInit() {
    this.getTrainerProfile();
  }

  private getTrainerProfile() {
    this.dataService.getProfile()
      .subscribe((data)=>{
        this.trainer = <TRAINER> data;
      },(err)=>{
        console.log(err)
      },()=>{
        console.log('done')
      })
  }
}
