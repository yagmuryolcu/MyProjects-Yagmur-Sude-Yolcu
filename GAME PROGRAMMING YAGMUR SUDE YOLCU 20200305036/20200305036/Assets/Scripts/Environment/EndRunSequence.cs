using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class EndRunSequence : MonoBehaviour
{
    public GameObject liveCoins;
    public GameObject endScreen;
    public GameObject fadeOut;



    void Start()
    {
        StartCoroutine(EndSequence());
    }



    IEnumerator EndSequence()
    {
        yield return new WaitForSeconds(3);
     //   liveCoins.SetActive(false);
       // endScreen.SetActive(false);
            yield return new WaitForSeconds(3);
        // fadeOut.SetActive(false);
        SceneManager.LoadScene(0);

    }
}
