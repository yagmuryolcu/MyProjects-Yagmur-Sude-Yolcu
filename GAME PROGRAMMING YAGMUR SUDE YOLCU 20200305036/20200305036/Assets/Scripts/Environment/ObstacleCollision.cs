using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ObstacleCollision : MonoBehaviour
{
    public GameObject thePlayer;
    public GameObject charModel;
   //public GameObject mainCam;
   
    public GameObject levelControl;

  void OnTriggerEnter(Collider other)
    { 
        this.gameObject.GetComponent<BoxCollider> ().enabled = false;
        thePlayer.GetComponent<PlayerMove>().enabled=false;
        charModel.GetComponent<Animator>().Play("Jump Backward");
        levelControl.GetComponent<EndScreen>().enabled=false;
     //  mainCam.GetComponent<Animator>().enabled = false;

        levelControl.GetComponent<EndRunSequence>().enabled = true;

    }
}
