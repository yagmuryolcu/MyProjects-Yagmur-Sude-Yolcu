using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class EndScreen : MonoBehaviour
{
    public GameObject disDisPlay;
    public GameObject disEndPlay;
    public int disRun;
    public bool addingDis = false;
    public float disDelay = 0.35f;

    // Update is called once per frame
    void Update()
    {
        if (!addingDis) 
        {
            addingDis = true;
            StartCoroutine(AddingDis()); 
        }
    }

    IEnumerator AddingDis()
    {
        disRun += 1;
       disDisPlay.GetComponent<Text>().text = "" + disRun; 

       disEndPlay.GetComponent<Text>().text = "" + disRun; 
        yield return new WaitForSeconds(disDelay);
        addingDis = false;
    }
}